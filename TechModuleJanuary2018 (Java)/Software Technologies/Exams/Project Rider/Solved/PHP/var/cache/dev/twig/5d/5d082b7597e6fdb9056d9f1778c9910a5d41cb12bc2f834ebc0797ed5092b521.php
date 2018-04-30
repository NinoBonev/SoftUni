<?php

/* @Twig/layout.html.twig */
class __TwigTemplate_ac4577b33a1508f28febae67b77f8b093663a6c91b13d448e6865acd42e10dd8 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'head' => array($this, 'block_head'),
            'body' => array($this, 'block_body'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_599b01a6f8af146aea9ce0a6ff8203f5e09cbc03fdb0be3e6afd894523bd863f = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_599b01a6f8af146aea9ce0a6ff8203f5e09cbc03fdb0be3e6afd894523bd863f->enter($__internal_599b01a6f8af146aea9ce0a6ff8203f5e09cbc03fdb0be3e6afd894523bd863f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/layout.html.twig"));

        $__internal_2dbeb420636ed0fd709ac66c432104503c8c334f67ee701940e4ec498bfc6276 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_2dbeb420636ed0fd709ac66c432104503c8c334f67ee701940e4ec498bfc6276->enter($__internal_2dbeb420636ed0fd709ac66c432104503c8c334f67ee701940e4ec498bfc6276_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/layout.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
    <head>
        <meta charset=\"";
        // line 4
        echo twig_escape_filter($this->env, $this->env->getCharset(), "html", null, true);
        echo "\" />
        <meta name=\"robots\" content=\"noindex,nofollow\" />
        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />
        <title>";
        // line 7
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
        <link rel=\"icon\" type=\"image/png\" href=\"";
        // line 8
        echo twig_include($this->env, $context, "@Twig/images/favicon.png.base64");
        echo "\">
        <style>";
        // line 9
        echo twig_include($this->env, $context, "@Twig/exception.css.twig");
        echo "</style>
        ";
        // line 10
        $this->displayBlock('head', $context, $blocks);
        // line 11
        echo "    </head>
    <body>
        <header>
            <div class=\"container\">
                <h1 class=\"logo\">";
        // line 15
        echo twig_include($this->env, $context, "@Twig/images/symfony-logo.svg");
        echo " Symfony Exception</h1>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/doc\">
                        <span class=\"icon\">";
        // line 19
        echo twig_include($this->env, $context, "@Twig/images/icon-book.svg");
        echo "</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Docs
                    </a>
                </div>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/support\">
                        <span class=\"icon\">";
        // line 26
        echo twig_include($this->env, $context, "@Twig/images/icon-support.svg");
        echo "</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Support
                    </a>
                </div>
            </div>
        </header>

        ";
        // line 33
        $this->displayBlock('body', $context, $blocks);
        // line 34
        echo "        ";
        echo twig_include($this->env, $context, "@Twig/base_js.html.twig");
        echo "
    </body>
</html>
";
        
        $__internal_599b01a6f8af146aea9ce0a6ff8203f5e09cbc03fdb0be3e6afd894523bd863f->leave($__internal_599b01a6f8af146aea9ce0a6ff8203f5e09cbc03fdb0be3e6afd894523bd863f_prof);

        
        $__internal_2dbeb420636ed0fd709ac66c432104503c8c334f67ee701940e4ec498bfc6276->leave($__internal_2dbeb420636ed0fd709ac66c432104503c8c334f67ee701940e4ec498bfc6276_prof);

    }

    // line 7
    public function block_title($context, array $blocks = array())
    {
        $__internal_831dd3fdaadb3e61b692b93c4e0edb0658bd7b75da3ed0c7c666e44ef9a50a3b = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_831dd3fdaadb3e61b692b93c4e0edb0658bd7b75da3ed0c7c666e44ef9a50a3b->enter($__internal_831dd3fdaadb3e61b692b93c4e0edb0658bd7b75da3ed0c7c666e44ef9a50a3b_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        $__internal_8a3fb53758e42702444508c30814e065b8528710fb12ea0d18cdaa510056ae34 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_8a3fb53758e42702444508c30814e065b8528710fb12ea0d18cdaa510056ae34->enter($__internal_8a3fb53758e42702444508c30814e065b8528710fb12ea0d18cdaa510056ae34_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        
        $__internal_8a3fb53758e42702444508c30814e065b8528710fb12ea0d18cdaa510056ae34->leave($__internal_8a3fb53758e42702444508c30814e065b8528710fb12ea0d18cdaa510056ae34_prof);

        
        $__internal_831dd3fdaadb3e61b692b93c4e0edb0658bd7b75da3ed0c7c666e44ef9a50a3b->leave($__internal_831dd3fdaadb3e61b692b93c4e0edb0658bd7b75da3ed0c7c666e44ef9a50a3b_prof);

    }

    // line 10
    public function block_head($context, array $blocks = array())
    {
        $__internal_6eadf621943b11d3e65fa6e1075703bb7d00d444f21d2676592286fa3025ad65 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_6eadf621943b11d3e65fa6e1075703bb7d00d444f21d2676592286fa3025ad65->enter($__internal_6eadf621943b11d3e65fa6e1075703bb7d00d444f21d2676592286fa3025ad65_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        $__internal_bc378e04b1b909467dde7d66343cbdc0cc9a74563414a94baaf183050dd6e5f2 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_bc378e04b1b909467dde7d66343cbdc0cc9a74563414a94baaf183050dd6e5f2->enter($__internal_bc378e04b1b909467dde7d66343cbdc0cc9a74563414a94baaf183050dd6e5f2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        
        $__internal_bc378e04b1b909467dde7d66343cbdc0cc9a74563414a94baaf183050dd6e5f2->leave($__internal_bc378e04b1b909467dde7d66343cbdc0cc9a74563414a94baaf183050dd6e5f2_prof);

        
        $__internal_6eadf621943b11d3e65fa6e1075703bb7d00d444f21d2676592286fa3025ad65->leave($__internal_6eadf621943b11d3e65fa6e1075703bb7d00d444f21d2676592286fa3025ad65_prof);

    }

    // line 33
    public function block_body($context, array $blocks = array())
    {
        $__internal_3978e2a6711f03d1640e29897a791e7af65e621cbd8cbd07e2b95a553e06ddec = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_3978e2a6711f03d1640e29897a791e7af65e621cbd8cbd07e2b95a553e06ddec->enter($__internal_3978e2a6711f03d1640e29897a791e7af65e621cbd8cbd07e2b95a553e06ddec_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        $__internal_08b080710023b76e367bea4b26dab0ae0745867bdaa037e0f26d2752e73cf410 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_08b080710023b76e367bea4b26dab0ae0745867bdaa037e0f26d2752e73cf410->enter($__internal_08b080710023b76e367bea4b26dab0ae0745867bdaa037e0f26d2752e73cf410_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        
        $__internal_08b080710023b76e367bea4b26dab0ae0745867bdaa037e0f26d2752e73cf410->leave($__internal_08b080710023b76e367bea4b26dab0ae0745867bdaa037e0f26d2752e73cf410_prof);

        
        $__internal_3978e2a6711f03d1640e29897a791e7af65e621cbd8cbd07e2b95a553e06ddec->leave($__internal_3978e2a6711f03d1640e29897a791e7af65e621cbd8cbd07e2b95a553e06ddec_prof);

    }

    public function getTemplateName()
    {
        return "@Twig/layout.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  137 => 33,  120 => 10,  103 => 7,  88 => 34,  86 => 33,  76 => 26,  66 => 19,  59 => 15,  53 => 11,  51 => 10,  47 => 9,  43 => 8,  39 => 7,  33 => 4,  28 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("<!DOCTYPE html>
<html>
    <head>
        <meta charset=\"{{ _charset }}\" />
        <meta name=\"robots\" content=\"noindex,nofollow\" />
        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />
        <title>{% block title %}{% endblock %}</title>
        <link rel=\"icon\" type=\"image/png\" href=\"{{ include('@Twig/images/favicon.png.base64') }}\">
        <style>{{ include('@Twig/exception.css.twig') }}</style>
        {% block head %}{% endblock %}
    </head>
    <body>
        <header>
            <div class=\"container\">
                <h1 class=\"logo\">{{ include('@Twig/images/symfony-logo.svg') }} Symfony Exception</h1>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/doc\">
                        <span class=\"icon\">{{ include('@Twig/images/icon-book.svg') }}</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Docs
                    </a>
                </div>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/support\">
                        <span class=\"icon\">{{ include('@Twig/images/icon-support.svg') }}</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Support
                    </a>
                </div>
            </div>
        </header>

        {% block body %}{% endblock %}
        {{ include('@Twig/base_js.html.twig') }}
    </body>
</html>
", "@Twig/layout.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\TwigBundle\\Resources\\views\\layout.html.twig");
    }
}
